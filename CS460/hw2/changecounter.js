/* Amount of money to "insert" */
var credit = 0;

/* Number of each bill dispensed */
var hundreds = 0;
var fifties = 0;
var twenties = 0;
var tens = 0;
var fives = 0;
var ones = 0;

function main() {
  $('#submit').on('click', function() { //when user clicks "Calculate" button
    $('#submit').prop('disabled', true); //prevents creation of multiple tables
    credit = financial(document.getElementById('input-amt').value);
    if(initialCheck() === true) { //if it passes, then execute block
      $('#input-amt').val(credit); //Sets textbox value in step 1. Mostly if user enters floating-point value (i.e. 0.001)
      dispenseChange();
      printTable();
    }
  });
}

/* Rounds any decimal values to nearest whole number */
function financial(val) {
  return Number.parseFloat(val).toFixed(0);
}

/* Checks input text and checkboxes. Half of it is for
browsers that do not recognize <input type="number">. (See
https://bugzilla.mozilla.org/show_bug.cgi?id=1398528 for
details)*/
function initialCheck() {
  if(isNaN(credit) || credit < 1) { //checks for invalid values
    alert("Please enter a number value higher than 0.");
    $('#submit').prop('disabled', false); //re-enable "calculate" button
    return false; //fails initial check
  }
  else if($('input[type=checkbox]').is(':checked') === false) { //checks if at least one checkbox is ticked.
    alert("Please check at least one checkbox in step 2.");
    $('#submit').prop('disabled', false); //re-enable "calculate" button
    return false; //fails initial check
  }
  else {
    return true;
  }
}

/* Resets number of bills dispensed, among other things */
function reset() {
  credit = 0;
  hundreds = 0;
  fifties = 0;
  twenties = 0;
  tens = 0;
  fives = 0;
  ones = 0;
  $('#submit').prop('disabled', false); //re-enables "Calculate" button
  $('#input-amt').val(""); //set textbox value to empty
  $('.col-sm-12').find('input:checkbox').prop('checked', true); //re-tick all checkboxes
}

function dispenseChange() {
  while(credit != 0) {
    if($('input[type=checkbox][name="hundred"]').is(':checked') && credit % 100 === 0) {
      credit -= 100;
      hundreds++;
    }
    else if($('input[type=checkbox][name="fifty"]').is(':checked') && credit % 50 === 0) {
      credit -= 50;
      fifties++;
    }
    else if($('input[type=checkbox][name="twenty"]').is(':checked') && credit % 20 === 0) {
      credit -= 20;
      twenties++;
    }
    else if($('input[type=checkbox][name="ten"]').is(':checked') && credit % 10 === 0) {
      credit -= 10;
      tens++;
    }
    else if($('input[type=checkbox][name="five"]').is(':checked') && credit % 5 === 0) {
      credit -= 5;
      fives++;
    }
    else if($('input[type=checkbox][name="one"]').is(':checked') && credit % 1 === 0) {
      credit--;
      ones++;
    }
    else {
      alert("It's not possible to properly dispense your requested change with the amount you entered and/or the checkboxes you ticked. Click the \"Start over\" button to try again.");
      credit = 0; //forces credit to "0" to stop infinite looping
    }
  }
}

function printTable() {
  $('#table-change').append("<div class='print-table'>\
    <h4>Your change is as follows:</h4>\
    <table>\
      <tr>\
        <th># of $100 Bills</th>\
        <th># of $50 Bills</th>\
        <th># of $20 Bills</th>\
        <th># of $10 Bills</th>\
        <th># of $5 Bills</th>\
        <th># of $1 Bills</th>\
      </tr>\
      <tr>\
        <td>" + hundreds + "</td>\
        <td>" + fifties + "</td>\
        <td>" + twenties + "</td>\
        <td>" + tens + "</td>\
        <td>" + fives + "</td>\
        <td>" + ones + "</td>\
      </tr>\
    </table>\
    <br>\
    <button id='clear-data' onclick=\"reset(); $('.print-table').remove();\">Start over</button>\
    <label>-- Clears table and resets the program</label>\
  </div>");
}

$(document).ready(main);

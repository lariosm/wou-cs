/**
 * Makes a request to BidRequest() in BidController */
function bidRequest() {
    var input = document.getElementById("listing-id").value; //retrieves listing ID from HTML ID attribute
    var id = parseInt(input); //parses the input as an int
    var source = "/Bid/BidRequest/" + id; //appends it to URI string.

    $.ajax({
        type: "GET",
        dataType: "json",
        url: source,
        success: showBids,
        error: ajaxError
    });
}

/**
 * Appends list of bids to view.
 * @param {any} bidList JSON response received from BidRequest() in BidController
 */
function showBids(bidList) {
    //Checks whether or not JSON response is empty.
    if (bidList.length == 0) { //Empty response, display message to user.
        $("#message").empty(); //Clears message if it already exists.
        $("#message").append("No bids to display. Be the first to bid on this item."); //appends "no bids" message to display to user.
    }
    else { //Loaded response; display bidding data.
        $("#message").empty(); //Clears message if it already exists.
        $(".bid-info").remove(); //Clears any old bidding data.
        //Displays row-by-row bidding data.
        for (var i = 0; i < bidList.length; i++) {
            $("table").append("<tr class=\"bid-info\"><td>" + bidList[i].Buyer + "</td><td>$" + Number(bidList[i].Amount).toLocaleString('en-US', { minimumFractionDigits: 2 }) + "</td></tr>");
        }
    }
}

/**
 * Displays pop-up message
 */
function ajaxError() {
    alert("Unable to reach server. Please try again later.");
}

/**
 * The main method that "drives" the script 
 */
function main() {
    bidRequest(); //makes initial call to bidRequest() method.

    var interval = 1000 * 5; //timer interval

    window.setInterval(bidRequest, interval); //refreshes bid list every 5 seconds
}

$(document).ready(main()); //Calls main() when page is loaded
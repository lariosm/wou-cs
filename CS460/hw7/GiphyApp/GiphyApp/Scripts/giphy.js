//list of "boring" words
var boringWords = ["i", "in", "a", "but", "going", "i'm", "my", ",", ".", "",
                   "for", "not", "of", "to", "from", "make", "just", "know",
                   "other", "this", "than", "then", "as", "he", "he's", "his",
                   "him", "she", "she's", "her", "so", "we", "is", "be", "see",
                   "you", "later", "the", "i've", "isn't", "got"];

/**
 * Sends request to GIPHY servers
 * @param {any} keyWord Word we want to get a .gif of
 */
function giphyRequest(keyWord) {
    var source = "Giphy/Image/" + keyWord;

    $.ajax({
        type: "GET",
        dataType: "json",
        url: source,
        success: displayGIF,
        error: ajaxError
    });
}

/**
 * Displays .gif image to client
 * @param {any} imageData JSON data received from GIPHY server
 */
function displayGIF(imageData) {
    var image = imageData.data.images.fixed_height_small.url; //URI of the .gif to display

    $("#live-display").append("<img src=\"" + image + "\"/>&nbsp;"); //Appends .gif to HTML document
}

/** 
 * Displays AJAX error as pop-up alert
 */
function ajaxError() {
    alert("Unable to load image");
}

/**
 * The main method which drives the script.
 */
function main() {
    $("#textbox").keypress(function (e) {
        if (e.keyCode == 32) { //Listens for spacebar press from input box
            var input = document.getElementById("textbox").value; //Gets text from input box.
            input = input.split(" "); //Splits words into an array.
            input = input[input.length - 1]; //Get the last word in "array"
            var word = input.toLowerCase(); //Converts word to all lowercase to check against "boring" words

            //Checks if the word is a "boring" word
            if (boringWords.includes(word)) { //It's a boring word
                $("#live-display").append("<label>" + input + "</label>&nbsp;") //Displays word as plain text
            }
            else { //It's a "fun" word
                giphyRequest(input); //Send request to GIPHY and display as a .gif.
            }
        }
    });
}

$(document).ready(main); //Calls main() when page is loaded.
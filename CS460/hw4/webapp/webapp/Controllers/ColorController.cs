using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Drawing;
using System.Linq;
using System.Text.RegularExpressions;
using System.Web;
using System.Web.Mvc;

namespace webapp.Controllers
{
    /// <summary>
    /// Controller for the create.cshtml page
    /// </summary>
    public class ColorController : Controller
    {
        /// <summary>
        /// GET method for the create.cshtml page
        /// </summary>
        /// <returns>view of create.cshtml page</returns>
        [HttpGet]
        public ActionResult Create()
        {
            ViewBag.Show = false;
            return View();
        }

        /// <summary>
        /// POST method for the create.cshtml page
        /// </summary>
        /// <param name="firstColor">hex pattern of first color</param>
        /// <param name="secondColor">hex pattern of second color</param>
        /// <returns>view of create.cshtml page with results of user's input</returns>
        [HttpPost]
        public ActionResult Create(string firstColor, string secondColor)
        {
            Regex hexColorPattern = new Regex("^#[a-fA-F0-9]{3,6}$"); //hex color pattern to be used for validation
            ViewBag.Show = false;

            if (hexColorPattern.IsMatch(firstColor) && hexColorPattern.IsMatch(secondColor)) //are inputs of hex color values? (Server-side input validation)
            {
                Color color1 = ColorTranslator.FromHtml(firstColor);
                Color color2 = ColorTranslator.FromHtml(secondColor);
                string finalColor; //stores hex color value after mixing colors

                int red; //stores "mixed" red values
                int blue; //stores "mixed" blue values
                int green; //stores "mixed" green values

                /**
                 * Performs color addition for each color value. If a color's combined
                 * value is more than 255, cap it at 255. Otherwise, store the result.
                 */

                //mixing red values
                if(color1.R + color2.R > 255)
                {
                    red = 255;
                }
                else
                {
                    red = color1.R + color2.R;
                }

                //mixing green values
                if(color1.G + color2.G > 255)
                {
                    green = 255;
                }
                else
                {
                    green = color1.G + color2.G;
                }

                //mixing blue values
                if (color1.B + color2.B > 255)
                {
                    blue = 255;
                }
                else
                {
                    blue = color1.B + color2.B;
                }

                finalColor = ColorTranslator.ToHtml(Color.FromArgb(255, red, green, blue)); //converts computed RGB values to hex color value

                //style attributes for displaying colors
                ViewBag.Square = "width: 70px; height: 70px; border: 1px #000 solid; border-radius: 10px; background: " + firstColor + ";";
                ViewBag.Square2 = "width: 70px; height: 70px; border: 1px #000 solid; border-radius: 10px; background: " + secondColor + ";";
                ViewBag.Square3 = "width: 70px; height: 70px; border: 1px #000 solid; border-radius: 10px; background: " + finalColor + ";";

                ViewBag.Show = true; //displays result to the user
            }
            else //if not, display error message to user
            {
                ViewBag.ErrorMessage = "Invalid input(s). Try using hex values like #F38FCB or #B3C.";
            }

            return View();
        }
    }
}
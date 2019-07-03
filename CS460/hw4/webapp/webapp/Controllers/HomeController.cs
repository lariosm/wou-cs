using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace webapp.Controllers
{
    /// <summary>
    /// Controller for "Home" pages
    /// </summary>
    public class HomeController : Controller
    {
        /// <summary>
        /// Displays the index.cshtml page
        /// </summary>
        /// <returns>view of index.cshtml</returns>
        public ActionResult Index()
        {
            return View();
        }

        /// <summary>
        /// GET method for MileConverter.cshtml page
        /// </summary>
        /// <returns>view of MileConverter.cshtml</returns>
        [HttpGet]
        public ActionResult MileConverter()
        {
            double miles;
            double metricResult = 0; //where metric conversion values will be stored
            string unit = Request.QueryString["unitselect"];
            ViewBag.Show = false;

            if(Request.QueryString["btn"] == "Convert") //has "Convert" button been pressed?
            {
                if (Double.TryParse(Request.QueryString["mileinput"], out miles)) //can input value be converted to a double?
                {
                    if(miles >= 0) //input value a positive number?
                    {
                        if (unit == "millimeters")
                        {
                            metricResult = miles * 1609000;
                            ViewBag.Show = true;
                        }
                        else if (unit == "centimeters")
                        {
                            metricResult = miles * 160934.4;
                            ViewBag.Show = true;
                        }
                        else if (unit == "meters")
                        {
                            metricResult = miles * 1609.344;
                            ViewBag.Show = true;
                        }
                        else if (unit == "kilometers")
                        {
                            metricResult = miles * 1.609;
                            ViewBag.Show = true;
                        }
                        else //not a valid unit of measure
                        {
                            ViewBag.Display = "Invalid unit type. Please try again.";
                        }
                    }
                    else //if not, let the user know
                    {
                        ViewBag.Display = "Negative values are not allowed. Please try again.";
                    }
                    

                    if (ViewBag.Show) //displays computed output to user
                    {
                        ViewBag.Display = miles + " miles is equal to " + metricResult + " " + unit;
                    }
                }
                else //if not, let the user know
                {
                    ViewBag.Display = "Invalid input. Please try again.";
                }
            }

            return View();
        }
    }
}
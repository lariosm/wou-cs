using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using WWImporters.Models;
using WWImporters.Models.ViewModel;

namespace WWImporters.Controllers
{
    public class HomeController : Controller
    {
        private WWIContext db = new WWIContext();

        /// <summary>
        /// Performs the search based on the keywords passed from search box
        /// </summary>
        /// <param name="query">keyword(s) to search</param>
        /// <returns>A list of Person objects</returns>
        [HttpGet]
        public ActionResult Index(string query)
        {
            IEnumerable<Person> people = db.People.Where(p => p.FullName.Contains(null)); //start out with an empty container
            ViewBag.ShowError = false; //do not show search error if loading the page for the first time or after a successful search
            ViewBag.ResultString = ""; //shows empty "result" string if loading the page for the first time or after a failed search

            if(!string.IsNullOrWhiteSpace(query)) //makes sure query is not blank or contains only whitespaces.
            {
                people = db.People.Where(peopleItem => peopleItem.FullName.Contains(query)); //performs the query
                if (!people.Any()) //No matches? It's a failed search.
                {
                    ViewBag.ShowError = true; //display failed search message
                }
                else //successful search
                {
                    ViewBag.ResultString = "Names matching your search: \"" + query + "\"";
                }
            }

            return View(people.ToList());
        }

        // GET: People/Details/5
        public ActionResult Details(int? id)
        {
            DashboardVM vm = new DashboardVM(); //Initalize view model
            ViewBag.PrimaryContact = false; //On initialization, person doesn't have primary contact.

            if (id == null) //Non-existant Person ID?
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest); //Send out a 400 bad request error.
            }

            vm.Person = db.People.Find(id); //Find person object associated with that ID

            if (vm.Person == null) //Non-existant Person object?
            {
                return HttpNotFound(); //Send out a 404 not found error.
            }

            if(vm.Person.Customers2.Any()) //Is person a primary contact?
            {
                ViewBag.PrimaryContact = true; //Person has primary contact
                vm.Customer = vm.Person.Customers2.FirstOrDefault(); //Get customer info

                //get all invoices and invoice lines
                var baseCode = vm.Customer.Orders.SelectMany(i => i.Invoices)
                                                  .SelectMany(il => il.InvoiceLines);

                ViewBag.GrossSales = baseCode.Sum(e => e.ExtendedPrice); //calculate gross sales
                ViewBag.GrossProfit = baseCode.Sum(lp => lp.LineProfit); //calculate total profit

                vm.InvoiceLine = baseCode.OrderByDescending(lp => lp.LineProfit)
                                         .Take(10)
                                         .ToList();
            }

            return View(vm);
        }
    }
}
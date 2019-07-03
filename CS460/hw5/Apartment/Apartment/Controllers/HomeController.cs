using Apartment.DAL;
using Apartment.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;

namespace Apartment.Controllers
{
    public class HomeController : Controller
    {
        //Gateway to database for accessing and manipulating data.
        private TenantContext db = new TenantContext();

        public ActionResult Index()
        {
            return View();
        }

        // GET: Home/Viewforms
        public ActionResult ViewForms()
        {
            return View(db.Tenants.OrderBy(Tenant => Tenant.Received).ToList());
        }

        // GET: Home/RequestForm
        public ActionResult RequestForm()
        {
            return View();
        }

        // POST: Home/RequestForm
        //[Bind] data annotation prevents any overposting attacks
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult RequestForm([Bind(Include = "ID, FirstName, LastName, PhoneNumber, ApartmentName, UnitNumber, Description, Checkbox, Received")] Tenant tenant)
        {   
            if (ModelState.IsValid) //Are required fields filled out?
            {
                //adds form infomation to database
                db.Tenants.Add(tenant);
                db.SaveChanges();
                return RedirectToAction("ViewForms");
            }

            return View(tenant);
        }

        // GET: Home/Delete/[ID]
        public ActionResult Delete(int? id)
        {
            if (id == null) //Non-existant ID?
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest); //Returns a 400 error
            }
            Tenant tenant = db.Tenants.Find(id); //looks up tenant by ID
            if (tenant == null) //Non-existant tenant object? Return an error page.
            {
                return HttpNotFound();
            }
            return View(tenant);
        }

        // POST: Home/Delete/[ID]
        //Deletes tenant request from database.
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Tenant tenant = db.Tenants.Find(id);
            db.Tenants.Remove(tenant);
            db.SaveChanges();
            return RedirectToAction("ViewForms");
        }

        //garbage collector for database
        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
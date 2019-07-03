using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using AuctionHouse.Models;

namespace AuctionHouse.Controllers
{
    public class HomeController : Controller
    {
        private AuctionData db = new AuctionData();

        // GET: Home
        public ActionResult Index()
        {
            var bids = db.Bids.OrderByDescending(b => b.TimeStamp)
                              .Take(10);

            return View(bids.ToList());
        }

        // GET: Home/PlaceBid
        public ActionResult PlaceBid()
        {
            ViewBag.BuyerID = new SelectList(db.Buyers, "ID", "Name");
            ViewBag.ItemID = new SelectList(db.Items, "ID", "Name");
            return View();
        }

        // POST: Home/PlaceBid
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult PlaceBid([Bind(Include = "ID,ItemID,BuyerID,Price")] Bid bid)
        {
            if (ModelState.IsValid)
            {
                db.Bids.Add(bid);
                db.SaveChanges();
                return RedirectToAction("Listings");
            }

            ViewBag.BuyerID = new SelectList(db.Buyers, "ID", "Name", bid.BuyerID);
            ViewBag.ItemID = new SelectList(db.Items, "ID", "Name", bid.ItemID);
            return View(bid);
        }

        // GET: Items
        public ActionResult Listings()
        {
            var items = db.Items.Include(i => i.Seller);
            return View(items.ToList());
        }

        // GET: Items/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Item item = db.Items.Find(id);
            if (item == null)
            {
                return HttpNotFound();
            }
            return View(item);
        }

        // GET: Items/Create
        public ActionResult Create()
        {
            ViewBag.SellerID = new SelectList(db.Sellers, "ID", "Name");
            return View();
        }

        // POST: Items/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ID,Name,Description,SellerID")] Item item)
        {
            if (ModelState.IsValid)
            {
                db.Items.Add(item);
                db.SaveChanges();
                return RedirectToAction("Listings");
            }

            ViewBag.SellerID = new SelectList(db.Sellers, "ID", "Name", item.Seller);
            return View(item);
        }

        // GET: Items/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Item item = db.Items.Find(id);
            if (item == null)
            {
                return HttpNotFound();
            }
            ViewBag.SellerID = new SelectList(db.Sellers, "ID", "Name", item.Seller);
            return View(item);
        }

        // POST: Items/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ID,Name,Description,SellerID")] Item item)
        {
            if (ModelState.IsValid)
            {
                db.Entry(item).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Listings");
            }
            ViewBag.SellerID = new SelectList(db.Sellers, "ID", "Name", item.Seller);
            return View(item);
        }

        // GET: Items/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Item item = db.Items.Find(id);
            if (item == null)
            {
                return HttpNotFound();
            }
            return View(item);
        }

        // POST: Items/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Item item = db.Items.Find(id);

            //Checks if listing has bids on it. By doing so, it prevents an exception from
            //being raised when deleting a listing because of existing bids on it.
            if (item.Bids.Any())
            {
                //If so, remove all bids from this listing
                db.Bids.Where(i => i.ItemID == id).ToList().ForEach(bidItem => db.Bids.Remove(bidItem));
            }
            db.Items.Remove(item);
            db.SaveChanges();
            return RedirectToAction("Listings");
        }

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

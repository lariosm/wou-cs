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
    public class BidController : Controller
    {
        private AuctionData db = new AuctionData();

        /// <summary>
        /// Makes a request to get the list of bids of a listing
        /// </summary>
        /// <param name="id">ID of a listing</param>
        /// <returns>List of bids in JSON format</returns>
        [HttpGet]
        public JsonResult BidRequest(int? id)
        {
            //Gets all bids associated with the specified item ID
            var bids = db.Bids.Where(b => b.ItemID == id)
                              .Select(i => new { Buyer = i.Buyer.Name, Amount = i.Price })
                              .OrderByDescending(b => b.Amount)
                              .ToList();

            return Json(bids, JsonRequestBehavior.AllowGet); //Returns bid list in JSON format
        }
    }
}
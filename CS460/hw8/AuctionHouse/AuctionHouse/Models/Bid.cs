namespace AuctionHouse.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    public partial class Bid
    {
        public int ID { get; set; }

        public int ItemID { get; set; }

        public int BuyerID { get; set; }

        [Required]
        [DisplayName("Bid amount")]
        public int Price { get; set; }

        [DisplayName("Bid placed on")]
        public DateTime TimeStamp { get; set; } = DateTime.Now;

        public virtual Buyer Buyer { get; set; }

        public virtual Item Item { get; set; }
    }
}

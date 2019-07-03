namespace AuctionHouse.Models
{
    using System;
    using System.Data.Entity;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Linq;

    public partial class AuctionData : DbContext
    {
        public AuctionData() : base("name=AuctionHouseDB")
        {
        }

        public virtual DbSet<Bid> Bids { get; set; }
        public virtual DbSet<Buyer> Buyers { get; set; }
        public virtual DbSet<Item> Items { get; set; }
        public virtual DbSet<Seller> Sellers { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Buyer>()
                .HasMany(e => e.Bids)
                .WithRequired(e => e.Buyer)
                .WillCascadeOnDelete(false);

            modelBuilder.Entity<Item>()
                .HasMany(e => e.Bids)
                .WithRequired(e => e.Item)
                .WillCascadeOnDelete(false);

            modelBuilder.Entity<Seller>()
                .HasMany(e => e.Items)
                .WithRequired(e => e.Seller)
                .HasForeignKey(e => e.SellerID)
                .WillCascadeOnDelete(false);
        }
    }
}

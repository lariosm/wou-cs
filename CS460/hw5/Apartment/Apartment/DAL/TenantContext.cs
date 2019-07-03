using Apartment.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace Apartment.DAL
{
    /// <summary>
    /// Acts as a bridge between database and web application
    /// </summary>
    public class TenantContext : DbContext
    {
        public TenantContext() : base("name=TenantForms")
        {

        }

        public virtual DbSet<Tenant> Tenants { get; set; }
    }
}
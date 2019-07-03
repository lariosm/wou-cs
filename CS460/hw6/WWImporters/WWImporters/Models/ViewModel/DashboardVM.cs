using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WWImporters.Models.ViewModel
{
    /// <summary>
    /// Allows multiple objects to be returned to the view
    /// </summary>
    public class DashboardVM
    {
        /// <summary>
        /// Person object
        /// </summary>
        public Person Person { get; set; }

        /// <summary>
        /// Customer object
        /// </summary>
        public Customer Customer { get; set; }

        /// <summary>
        /// List of invoice objects
        /// </summary>
        public IEnumerable<Invoice> Invoice { get; set; }

        /// <summary>
        /// List of InvoiceLine objects
        /// </summary>
        public IEnumerable<InvoiceLine> InvoiceLine { get; set; }
    }
}
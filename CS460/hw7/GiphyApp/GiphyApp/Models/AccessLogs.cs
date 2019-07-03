using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace GiphyApp.Models
{
    public class AccessLogs
    {
        /// <summary>
        /// Primary key
        /// </summary>
        [Key]
        [Required]
        public int ID { get; set; }

        /// <summary>
        /// Client's IP address
        /// </summary>
        [Required]
        public String IPAddress { get; set; }

        /// <summary>
        /// Word entered to input box
        /// </summary>
        [Required]
        public String KeyWord { get; set; }

        /// <summary>
        /// Client's browser agent information
        [Required]
        public String AgentString { get; set; }

        /// <summary>
        /// Time the request was made
        [Required]
        public DateTime TimeStamp { get; set; } = DateTime.Now;
    }
}
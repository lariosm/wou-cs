using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Apartment.Models
{
    public class Tenant
    {
        [Key]
        public int ID { get; set; }

        [Required(ErrorMessage = "This field cannot be left blank."), Display(Name = "First name")]
        [StringLength(25, MinimumLength = 3, ErrorMessage = "Must be between 3-25 characters.")]
        public string FirstName { get; set; }

        [Required(ErrorMessage = "This field cannot be left blank."), Display(Name = "Last name")]
        [StringLength(35, MinimumLength = 3, ErrorMessage = "Must be between 3-35 characters.")]
        public string LastName { get; set; }

        [Required(ErrorMessage = "Phone number must be in proper format. i.e. 555-555-5555")]
        [Display(Name = "Phone number"), Phone]
        public string PhoneNumber { get; set; }

        [Required(ErrorMessage = "This field cannot be left blank."), Display(Name = "Apartment name")]
        [StringLength(40, MinimumLength = 8, ErrorMessage = "Must be between 8-40 characters.")]
        public string ApartmentName { get; set; }

        [Required(ErrorMessage = "This field cannot be left blank."), Display(Name = "Unit number")]
        [Range(1, 99, ErrorMessage = "Please enter a one or two-digit number")]
        public int UnitNumber { get; set; }

        [Required(ErrorMessage = "Please provide a description of your request."), Display(Name = "Description")]
        public string Description { get; set; }

        [Display(Name = "Granted permission?")]
        public bool Checkbox { get; set; }

        //DateTime.Now: Sets timestamp on Tenant object creation.
        [Display(Name = "Received")]
        public DateTime Received { get; set; } = DateTime.Now;
    }
}
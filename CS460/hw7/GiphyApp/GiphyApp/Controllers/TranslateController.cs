using GiphyApp.DAL;
using GiphyApp.Models;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;

namespace GiphyApp.Controllers
{
    public class TranslateController : Controller
    {
        private AccessLogsContext db = new AccessLogsContext();

        /// <summary>
        /// Sends request to GIPHY and returns it in JSON form
        /// </summary>
        /// <param name="word">Word to look up</param>
        /// <returns>Returns GIPHY response in JSON form</returns>
        public JsonResult TranslateGIF(string word)
        {
            //URI to contact GIPHY's servers
            string uri = "https://api.giphy.com/v1/stickers/translate?api_key=" +
                         System.Web.Configuration.WebConfigurationManager.AppSettings["GiphyKey"] +
                         "&s=" + word;

            //Create a web request
            WebRequest dataRequest = WebRequest.Create(uri);

            //Get the (JSON) data 
            Stream dataStream = dataRequest.GetResponse().GetResponseStream();

            //Parse the received (JSON) data
            var parsedData =  new System.Web.Script.Serialization.JavaScriptSerializer()
                                  .DeserializeObject(new StreamReader(dataStream)
                                  .ReadToEnd());

            //*****Requests logging code*****
            AccessLogs log = new AccessLogs();

            log.IPAddress = Request.UserHostAddress; //logs client's IP address
            log.KeyWord = word; //logs client's requested word
            log.AgentString = Request.UserAgent; //logs client's browser information

            //saves current request to database
            db.Logs.Add(log);
            db.SaveChanges();
            //*******************************

            //return the (JSON) data
            return Json(parsedData, JsonRequestBehavior.AllowGet);
        }
    }
}
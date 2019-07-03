using GiphyApp.Models;
using System.Data.Entity;

namespace GiphyApp.DAL
{
    /// <summary>
    /// Acts as a bridge between database and web application
    /// </summary>
    public class AccessLogsContext : DbContext
    {
        public AccessLogsContext() : base("name=AccessLogsDB") {}

        public virtual DbSet<AccessLogs> Logs { get; set; }
    }
}
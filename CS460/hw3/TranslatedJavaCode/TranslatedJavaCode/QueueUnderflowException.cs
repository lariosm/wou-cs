using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TranslatedJavaCode
{
    /// <summary>
    /// A custom unchecked excception to represent situations where
    /// an illegal operation was performed on an empty queue.
    /// </summary>
    public class QueueUnderflowException : Exception
    {
        public QueueUnderflowException() : base()
        {
            //No code here
        }

        public QueueUnderflowException(string message) : base(message)
        {
            //No code here
        }

    }
}

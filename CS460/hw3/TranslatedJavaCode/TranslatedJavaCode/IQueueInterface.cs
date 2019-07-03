using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TranslatedJavaCode
{
    /// <summary>
    /// A FIFO queue interface. This ADT is suitable for a
    /// singly-linked queue.
    /// </summary>
    public interface IQueueInterface<T>
    {
        /// <summary>
        /// Add an element to the rear of the queue.
        /// </summary>
        /// <param name="element">The element to be enqueued</param>
        /// <returns>The element that was enqueued</returns>
        T Push(T element);

        /// <summary>
        /// Remove and return the front element
        /// </summary>
        /// <returns>Return the removed element</returns>
        T Pop();

        /// <summary>
        /// Test if the queue is empty
        /// </summary>
        /// <returns>Whether the queue is empty</returns>
        bool IsEmpty();
    }
}

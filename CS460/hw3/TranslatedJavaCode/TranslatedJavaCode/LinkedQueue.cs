using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TranslatedJavaCode
{
    /// <summary>
    /// A singly-linked FIFO queue.
    /// From Dale, Joyce and Weems "Object-Oriented Data Structures Using Java"
    /// Modified for CS460 HW3
    /// 
    /// See IQueueInterface.cs for documentation.
    /// </summary>
    public class LinkedQueue<T> : IQueueInterface<T>
    {
        private Node<T> Front;
        private Node<T> Rear;

        public LinkedQueue()
        {
            Front = null;
            Rear = null;
        }

        public T Push(T element)
        {
            if (element == null)
            {
                throw new NullReferenceException();
            }

            if (IsEmpty())
            {
                Node<T> tmp = new Node<T>(element, null);
                Rear = Front = tmp;
            }
            else
            {
                //General case
                Node<T> tmp = new Node<T>(element, null);
                Rear.Next = tmp;
                Rear = tmp;
            }
            return element;
        }

        public T Pop()
        {
            T tmp = default(T);
            if (IsEmpty())
            {
                throw new QueueUnderflowException("The queue was empty when pop was invoked.");
            }
            else if (Front == Rear)
            {
                //one item in queue
                tmp = Front.Data;
                Front = null;
                Rear = null;
            }
            else
            {
                //General case
                tmp = Front.Data;
                Front = Front.Next;
            }
            return tmp;
        }

        public bool IsEmpty()
        {
            if (Front == null && Rear == null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TranslatedJavaCode
{
    /// <summary>
    /// Singly-linked node class
    /// </summary>
    public class Node<T>
    {
        public T Data;
        public Node<T> Next;


        public Node(T data, Node<T> next)
        {
            Data = data;
            Next = next;
        }
    }
}

using System;
using System.Collections.Generic;

public class Node
{
    public int Value { get; set; }
    public Node Right { get; set; }
    public Node Left { get; set; }

    public static Node FromString(string body)
    {
        const string noneValue = "none";

        if (String.IsNullOrEmpty(body) || String.Empty == body)
        {
            return None();
        }

        var entry = "";
        var hasLeftChild = false;
        var currentNode = new Node();
        var treeDetails = new Stack<Tuple<Node, bool>>();

        for (var i = 1; i < body.Length - 1; i++)
        {
            switch (body[i])
            {
                case '(':
                    treeDetails.Push(Tuple.Create(currentNode, hasLeftChild));
                    currentNode = new Node();
                    hasLeftChild = false;
                    break;
                case ')':
                    var childNode = currentNode;
                    var detail = treeDetails.Pop();
                    currentNode = detail.Item1;
                    hasLeftChild = detail.Item2;

                    if (!hasLeftChild)
                    {
                        currentNode.Left = childNode;
                        hasLeftChild = true;
                    }
                    else
                        currentNode.Right = childNode;
                    break;
                case ' ':
                    continue;
                case ',':
                    if (entry.ToLower() != noneValue)
                        currentNode.Value = int.Parse(entry);
                    entry = "";
                    break;
                default:
                    entry += body[i];
                    break;
            }
        }

        return currentNode;
    }

    public static Node None()
    {
        return null;
    }

    public static bool IsNone(Node node)
    {
        return null == node;
    }
}

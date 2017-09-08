using System.Collections.Generic;
using System.Linq;

public static class CountVisibleNodesSolution
{
    /// <summary>
    /// Counts visible nodes. A node of tree T containing value V is described as visible if path from the root of the tree to that node does not contain a node with value exceeding V.
    /// In particular, the root is always visible and nodes with values lower than that of the root are never visible. 
    /// An empty binary tree is denoted by None. A non-empty tree is denoted as (X, L, R), where X is the value contained in the root and L and R the left and right subtrees, respectively.
    /// Example:
    /// (5, (3, (20, None, None), (21, None, None)), (10, (1, None, None), None)) => contains 4 nodes visible: 5, 20, 21, 10
    /// (8, (2, (8, None, None), (7, None, None)), (6, None, None)) => contains two nodes visible: 8, 8 
    /// </summary>
    /// <param name="node"></param>
    /// <returns></returns>
    public static int CountVisibleNodes(Node node)
    {
        return Node.IsNone(node) ? 0 : Traverse(node, 0, new List<Node>());
    }

    private static int Traverse(Node current, int totalVisible, ICollection<Node> visited)
    {
        if (!visited.Any(previous => previous.Value > current.Value))
            ++totalVisible;

        if (Node.IsNone(current.Left) && Node.IsNone(current.Right))
            return totalVisible;

        visited.Add(current);

        totalVisible = new[] { current.Left, current.Right }
            .Where(node => !Node.IsNone(node))
            .Aggregate(totalVisible, (current1, node) => Traverse(node, current1, visited));

        visited.Remove(current);

        return totalVisible;
    }
}

#To add a tree to this program create a dict called testTree where testTree = {Root : [Children, children], child : [child's children]}
#then set the function calls at the botom of the program to the Root's value

#A tree will be represented with a dictionary and key value pairs where the key is the node and the pairs are the chilren of that node
# Node 1 will be the root of my tree
#The tree will look like this from figure 1
# 1 > 2,3,4
# 2 > 5,6
# 3 > 7,8
# 4 > 9,10
# 5 > 11, 12
# 6 > 
# 7 > 
# 8 > 
# 9 > 13, 14
# 10 > 15, 16
# 11 > 
# 12 > 17
# 13 > 
# 14 > 
# 15 > 
# 16 > 
# 17 >

class Node:
    def __init__(self, key):
        self.key = key
        self.children = None


root = Node(1)
node2 = Node(2)
node3 = Node(3)
node4 = Node(4)
node5 = Node(5)
node6 = Node(6)
node7 = Node(7)
node8 = Node(8)
node9 = Node(9)
node10 = Node(10)
node11 = Node(11)
node12 = Node(12)
node13 = Node(13)
node14 = Node(14)
node15 = Node(15)
node16 = Node(16)
node17 = Node(17)

root.children = [node2, node3, node4]
node2.children = [node5, node6]
node3.children = [node7, node8]
node4.children = [node9, node10]
node5.children = [node11, node12]
node9.children = [node13, node14]
node10.children = [node15, node16]
node12.children = [node17]


#Implementing the DFS algo
#DFS pre order will go down the left subtree until there are no more nodes then the right subtree 
#this function will take in the current node we are anlyzing then recurse on the list by looking up the list of children nodes for that node
def DFSpreorder(node):
    #Exit if the node is NULL
    if node is None:
        return
    #first get the list of the children nodes for that node
    children = node.children
    if children is None:
        print(node.key)
        return
    #Then it will call its self against every element of the children list from left to right
    for child in children:
        DFSpreorder(child)
    #finally it will print the current node it is at
    print(node.key)

#implementing BFS
#BFS will visit all nodes on a given level then traverse the tree down to the next level
def BFSlevel(node):
    #Return if the node is NULL
    if node is None:
        return
    #Make a list with all of the nodes at that given level
    currentLevel = []
    #Add the node to the current level
    currentLevel.append(node)
    #While there are still elements in the current level continue running
    while(len(currentLevel) > 0):
        #print the first element and remove it from the front of the current level
        print(currentLevel[0].key)
        #The new node to find the children of is the node at the front of the list
        newNode = currentLevel.pop(0)
        #Add all the children of the current newNode
        if newNode.children:
            for child in newNode.children:
                currentLevel.append(child)


print("-------------------DFS-------------------")
#Param is the root node
DFSpreorder(root)
print("-------------------BFS-------------------")
#Param is the root node
BFSlevel(root)

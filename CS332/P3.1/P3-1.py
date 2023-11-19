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
testTree = {1 : [2, 3, 4], 2 : [5, 6], 3: [7, 8], 4 : [9, 10], 5 : [11, 12], 6 : [], 7 : [], 8 : [], 9 : [13, 14], 10 : [15, 16], 11: [], 12 : [17], 13 : [], 14 : [], 15 : [], 16:[], 17:[]}
#testTree = {}
#Implementing the DFS algo
#DFS pre order will go down the left subtree until there are no more nodes then the right subtree 
#this function will take in the current node we are anlyzing then recurse on the list by looking up the list of children nodes for that node
def DFSpreorder(node):
    #Exit if the node is NULL
    if node is None:
        return
    #first get the list of the children nodes for that node
    children = testTree[node]
    #Then it will call its self against every element of the children list from left to right
    for child in children:
        DFSpreorder(child)
    #finally it will print the current node it is at
    print(node)

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
        print(currentLevel[0])
        #The new node to find the children of is the node at the front of the list
        newNode = currentLevel.pop(0)
        #Add all the children of the current newNode
        for child in testTree[newNode]:
            currentLevel.append(child)


print("-------------------DFS-------------------")
#Param is the root node
DFSpreorder(1)
print("-------------------BFS-------------------")
#Param is the root node
BFSlevel(1)
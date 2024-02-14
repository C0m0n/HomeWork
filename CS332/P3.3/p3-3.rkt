#lang racket
(define tree '(1 (2 (5 (11) (12 (17))) (6)) (3 (7) (8)) (4 (9 (13) (14)) (10(15)(16)))))

;DFS
(define (DFS tree)
  ;if the tree is empty do not append
  (if (null? tree)
     '()
     ;if there are nodes call the dfschild with the cdr of the tree and add the car to the back
     (append (DFS-child (cdr tree)) (list (car tree)))))

(define (DFS-child childTree)
  (if (null? childTree)
      ;if there are no nodes do not append
      '()
      ;if there are nodes call the dfs on the car of the tree which is the left most node then recurse on the center and right nodes
      (append (DFS (car childTree)) (DFS-child (cdr childTree)))))

;BFS
(define (BFS tree)
  (define (BFS-helper queue)
    ;if the queue is empty do not append anything
    (if (null? queue)
        '()
        ;bind the values of the first node to the branch
        ;bind the values of the remaining nodes to the cdr of the queue
        ;bind the value of the car of the branch to the node value which represents the number
        ;bind the values of the remaining children to the cdr of the branch so that we can send it to the back of the list for recursion
        ;https://docs.racket-lang.org/reference/let.html
        (let* ([branch (car queue)]
               [remaining-nodes (cdr queue)]
               [node-value (car branch)]
               [children-node (cdr branch)])
          ;if the current branch is empty recurse on the remaining nodes 
          (if (null? branch)
              (BFS-helper remaining-nodes)
              ;if there are members of this branch append the node value and recurse on the remaining nodes with the children in the back
              (cons (list node-value)(BFS-helper(append remaining-nodes children-node)))))))
  ;kick off the helper function with the 
  (BFS-helper (list tree)))
    


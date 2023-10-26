(< 1 2)
(< 2 1)
(< 5 5)

(> 1 2)
(> 2 1)
(> 5 5)

(<= 1 2)
(<= 2 1)
(<= 5 5)

(>= 1 2)
(>= 2 1)
(>= 5 5)

(and 1 2)
(and 3 nil)
(and nil 3)

(or 2 nil)
(or 5 4)
(or nil 4)

(not 1)
(not nil)

(eval (quote (+ 1 2)))
(eval (- 1 2))

(cons 2 3)
(cons 5 (cons 4 (cons 1 nil)))

(cond (nil 1) (T 2))
(cond (T 1) (nil 2))
(cond (nil 2) ((<= 4 3) 4) ((<= 3 3) 5))
(cond (nil 2) ((+ 4 3) 7) (nil 4))
(cond (T 6) (nil 8) (nil 9))

(quote (+ 1 2))
(quote (cond (nil 1) (T 2)))

(list)
(list 1)
(list 1 2)
(list 1 2 (+ 2 2))


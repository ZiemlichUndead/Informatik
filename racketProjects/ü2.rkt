#lang racket
(define (nat-wurzel n)
  (nat-wurzel-iter 1 1 1 n))

(define (nat-wurzel-iter summe counter summanden n)
  (if(>= summe n)
     summanden
     (nat-wurzel-iter (+ summe (+ counter 2)) (+ counter 2) (+ summanden 1) n)))


(define (reverse-int x)

  (define (reverse-int-iter vorher nachher)

    (if (= vorher 0)
      nachher
      (reverse-int-iter (quotient vorher 10) (+ (* nachher 10) (remainder vorher 10)))
    )
  )
  (reverse-int-iter x 0)
)

(define (aufsteigendes-produkt? a b c d)
  (and (< a b) (< b c) (< c d) (= (+ a b c) d))
)


















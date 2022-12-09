#lang racket

(define (append lst x)
  (cond
    ((and (null? lst) (null? x)) lst)
    ((null? lst) (cons x '())) ; here's the change
    (else (cons (car lst) (append (cdr lst) x)))))

(define nil '())

(define (compress liste)

    (define (compress-iter liste neueListe letztesZeichen zeichenAnzahl)

        (let* (
                (zeichen (car liste))
                (selbesZeichen (eq? zeichen letztesZeichen))
                (nzeichenAnzahl (if selbesZeichen (+ zeichenAnzahl 1) 1))
            )

      
      
      (if (eq? (cdr liste) nil)
                
            (if(< 1 zeichenAnzahl)
                (append (append neueListe nzeichenAnzahl) zeichen)
                (append (append neueListe letztesZeichen) zeichen)
            )
            
            (compress-iter 
                (cdr liste)
                (if selbesZeichen
                    neueListe
                    (if (< 1 zeichenAnzahl) 
                        (append (append neueListe zeichenAnzahl) letztesZeichen)
                        (append neueListe letztesZeichen)
                    )
                ) 
                (if selbesZeichen
                    letztesZeichen
                    zeichen
                )
                nzeichenAnzahl
            )
        )
        )
      
    )

    (compress-iter liste nil nil 1)
)

(compress '(a b c d e f))
(compress '(a b b c c c))
(compress '(a b b c c c a b c)) 
(compress '(a a a a a a a a a a)) 

#lang racket


(define (variable? x) (symbol? x))

(define (=variable? v1 v2)
  (and 
    (variable? v1)
    (variable? v2)
    (eq? v1 v2)
  )
)
  
(define (summe? x)
  (and 
    (pair? x) 
    (eq? (car x) '+)
  )
)
  
(define (addend s) (cadr s))

(define (augend s) (caddr s))

(define (produkt? x)
  (and (pair? x) (eq? (car x) '*)))

(define (multiplikator p) (cadr p))

(define (multiplikand p) (caddr p))

(define (=number? exp num)
  (and (number? exp) (= exp num))
)

(define (konstr-summe a1 a2)
  (cond 
    ((=number? a1 0) a2)

        ((=number? a2 0)
          a1
        )

        ((and (number? a1)(number? a2))
          (+ a1 a2)
        )

        (else (list '+ a1 a2))
  )
)

(define (konstr-produkt m1 m2)
  (cond 
    ((or (=number? m1 0) (=number? m2 0))
      0
    )

    ((=number? m1 1)
      m2
    )

    ((=number? m2 1)
      m1
    )

    ((and (number? m1) (number? m2))
      (* m1 m2)
    )

    (else (list '* m1 m2))
  )
)


(define (ableiten ausdruck var)

  (cond 
    ((number? ausdruck) 0)

    ((variable? ausdruck)
      (if (=variable? ausdruck var) 
        1
        0
      )
    )

    ((summe? ausdruck)
      (konstr-summe 
        (ableiten (addend ausdruck) var)
        (ableiten (augend ausdruck) var)
      )
    )

    ((produkt? ausdruck)
      (konstr-summe

        (konstr-produkt 
          (multiplikator ausdruck)
          (ableiten (multiplikand ausdruck) var)
        )

        (konstr-produkt 
          (ableiten (multiplikator ausdruck) var)
          (multiplikand ausdruck)
        )
      )
    )

    (else
      (display 
        "Unbekannter Ausdruck in ableiten"
        ausdruck
        )
    )
  )
)
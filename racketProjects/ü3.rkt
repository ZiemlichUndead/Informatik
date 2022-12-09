#lang racket



(define (count-perm x)
    (define (count-perm-iter x result counter)
        (if (= counter x)
            result
            (count-perm-iter x (* result (- x counter)) (+ counter 1))
        )
    )
    (count-perm-iter x 1 0)
)

(define (isbn-test x)
    (define (isbn-test-iter x counter result)
        (if (= counter 0)
            result
            (isbn-test-iter (quotient x 10) (- counter 1) (+ result (* counter (remainder x 10))))
        )

    )
    (let ((result (remainder (isbn-test-iter x 9 0) 11)))
        (if (= result 10)
            "X"
            result
        )
    )
)


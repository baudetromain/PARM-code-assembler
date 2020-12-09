main:
        sub     sp, sp, #12
        mov     r0, #0
        str     r0, [sp, #8]
        mov     r1, #1
        str     r1, [sp, #4]
        ldr     r1, [sp, #8]
        ldr     r2, [sp, #4]
        add     r1, r1, r2
        str     r1, [sp]
        add     sp, sp, #12
        bx      lr
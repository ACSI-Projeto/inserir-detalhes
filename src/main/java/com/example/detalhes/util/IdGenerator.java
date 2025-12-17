package com.example.detalhes.util;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {

    private static final AtomicLong clienteCounter = new AtomicLong(0);

    public static long nextClienteId() {
        return clienteCounter.incrementAndGet();
    }
}

package com.git.zxxxd.lambda;

@FunctionalInterface
public interface FriFunction<A,B,C,D,T> {
    T apply(A a,B b,C c,D d);
}

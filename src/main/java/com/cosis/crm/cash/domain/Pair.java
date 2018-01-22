package com.cosis.crm.cash.domain;

import java.io.Serializable;

/**
 * @author cosis
 *自定义键值对数据
 * @param <F>
 * @param <S>
 */
public class Pair<F,S> implements Serializable {
    private static final long serialVersionUID = -2897239843984729837L;

    private F first;
    private S second;

    public Pair() {
        super();
    }

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Pair pair = (Pair) o;

        if (first != null ? !first.equals(pair.first) : pair.first != null)
            return false;
        if (second != null ? !second.equals(pair.second) : pair.second != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }
}

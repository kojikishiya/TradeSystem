package kk.common.IF;

public interface IDelegate<T,R> {

	R invoke(T t);
	
}

package com.show.zyh.show_time.cool;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 延迟器加载实现
 * Created by zyh(${2422634506@qq.com})
 * 2017：09:12
 */

public class Lazy<T>{
    private final  Supplier<T>mSuppler;
    private AtomicReference<T>mValue = new AtomicReference<T>();

    private Lazy(Supplier<T> supplier){
        this.mSuppler = supplier;
    }

    public T get(){
        //Gets the current value.
        T cachaed = mValue.get();
        if(cachaed == null){
          final  T obj = mSuppler.call();
            if (mValue.compareAndSet(null,obj)){
                return obj;
            }else{
                return mValue.get();
            }
        }else{
            return cachaed;
        }

    }

    public T getPresent() {
        return mValue.get();
    }

    @Deprecated
    public boolean isSet(){
        return isPresent();
    }

    public boolean isPresent(){
        return null != mValue.get();
    }

    /**
     * 移除已加载的值
     */
    public void remove(){
        mValue.set(null);
    }

    public static <T>Lazy<T> from(Supplier<T>supplier){
            return new Lazy<T>(supplier);
    }
}

package com.show.zyh.show_time.cool;

import android.support.annotation.NonNull;


/**
 * Created by zyh(${2422634506@qq.com})
 * ${Date}09:13
 */

public interface Supplier<T>{
    @NonNull T call();
}

package com.song.songup.livedata.liveData;

import android.arch.lifecycle.LiveData;

import java.math.BigDecimal;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/5 13:49
 * 修改备注：
 */
public class StockLiveData extends LiveData<String> {
    private StockManager mStockManager;
    private SimplePriceListener mSimplePriceListener = price ->{
        setValue(price);
    };

    public StockLiveData(StockManager mStockManager) {
        this.mStockManager = mStockManager;
    }

    @Override
    protected void onActive() {
        super.onActive();
        mStockManager.requestPriceUpdates(mSimplePriceListener);

    }

    @Override
    protected void onInactive() {
        super.onInactive();
        mStockManager.removeUpdates(mSimplePriceListener);
    }

    public interface SimplePriceListener{
        public void onPriceChange(String price);
    }

    public class StockManager{
        SimplePriceListener simplePriceListener;
        public void requestPriceUpdates(SimplePriceListener mSimplePriceListene){
            this.simplePriceListener = mSimplePriceListener;
        }

        public void removeUpdates(SimplePriceListener mSimplePriceListene){
            this.simplePriceListener = null;
        }

    }

}

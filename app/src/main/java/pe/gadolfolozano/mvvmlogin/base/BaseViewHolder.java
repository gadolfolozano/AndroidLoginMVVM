package pe.gadolfolozano.mvvmlogin.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by adolfo on 10/03/18.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBind(int position);
}

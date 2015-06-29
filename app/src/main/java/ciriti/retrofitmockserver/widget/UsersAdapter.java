package ciriti.retrofitmockserver.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ciriti.retrofitmockserver.R;
import ciriti.retrofitmockserver.bean.RespBean;

/**
 * Created by ciriti on 29/06/15.
 */
public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder>{

    List<RespBean.User> users;

    public UsersAdapter(List<RespBean.User> users) {
        this.users = users;

    }public UsersAdapter() {
        this.users = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecycleItemLayout view = (RecycleItemLayout)View.inflate(parent.getContext(), R.layout.item_users_recycleview, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static final class ViewHolder extends RecyclerView.ViewHolder{

        RecycleItemLayout recycleItemLayout;

        public ViewHolder(RecycleItemLayout itemView) {
            super(itemView);
            this.recycleItemLayout = itemView;
        }

        public void bind(RespBean.User user){
            recycleItemLayout.bindData(user);
        }
    }
}

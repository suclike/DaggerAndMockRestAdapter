package ciriti.retrofitmockserver.widget;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ciriti.retrofitmockserver.R;
import ciriti.retrofitmockserver.bean.RespBean;

/**
 * Created by ciriti on 29/06/15.
 */
public class UsersRecycleViewAdapter extends EmptyRecyclerView.Adapter<UsersRecycleViewAdapter.ViewHolder> implements View.OnClickListener{

    List<RespBean.User> users;

    public UsersRecycleViewAdapter(List<RespBean.User> users) {
        this.users = users;

    }public UsersRecycleViewAdapter() {
        this.users = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecycleItemLayout view = (RecycleItemLayout)View.inflate(parent.getContext(), R.layout.item_users_recycleview, null);
        view.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        RecycleItemLayout recycleItemLayout = (RecycleItemLayout)v;
        Toast.makeText(v.getContext(), "name[" + recycleItemLayout.user.displayName + "] age[" + recycleItemLayout.user.age + "]", Toast.LENGTH_SHORT).show();
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

    public void addData(List<RespBean.User> usersList){

        Log.i(UsersRecycleViewAdapter.class.getName(),"adapterusersList[" + usersList.size() +"]");
        Log.i(UsersRecycleViewAdapter.class.getName(),"adapterusers[" + users.size() +"]");

        int indexStart = users.size();
        users.addAll(usersList);
        notifyItemRangeInserted(indexStart, usersList.size());

        Log.i(UsersRecycleViewAdapter.class.getName(),"adapterusersADDED[" + users.size() +"]");

    }
}

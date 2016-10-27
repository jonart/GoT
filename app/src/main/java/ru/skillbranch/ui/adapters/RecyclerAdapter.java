package ru.skillbranch.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ru.skillbranch.utils.ConstantManager;
import ru.skillbranch.data.storage.models.Member;
import ru.skillbranch.got.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MemberViewHolder> {

    private MemberViewHolder.ItemClickListener mItemClickListener;
    private List<Member> mMembers;
    private int mHouseId;

    public RecyclerAdapter(List<Member> members, int id, MemberViewHolder.ItemClickListener itemClickListener) {
        mMembers = members;
        mHouseId = id;
        mItemClickListener = itemClickListener;
    }

    @Override
    public MemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);

        MemberViewHolder viewHolder = new MemberViewHolder(view, mItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MemberViewHolder holder, int position) {

        final Member member = mMembers.get(position);
        holder.name.setText(member.getName());
        holder.words.setText(member.getWords());
        switch (mHouseId) {
            case ConstantManager.STARKS_HOUSE_ID:
                holder.imageView.setImageResource(R.drawable.stark);
                break;
            case ConstantManager.LANNISTERS_HOUSE_ID:
                holder.imageView.setImageResource(R.drawable.lanister);
                break;
            case ConstantManager.TARGARYENS_HOUSE_ID:
                holder.imageView.setImageResource(R.drawable.targarien);
                break;
            default:
                holder.imageView.setImageResource(R.drawable.starkhouse);
        }
    }


    @Override
    public int getItemCount() {
        return mMembers.size();
    }


    public static class MemberViewHolder extends RecyclerView.ViewHolder implements OnClickListener {

        public TextView name;
        public TextView words;
        public ImageView imageView;
        private ItemClickListener listener;
        public LinearLayout linearLayout;

        public MemberViewHolder(View itemView, ItemClickListener itemClickListener) {
            super(itemView);

            this.listener = itemClickListener;
            name = (TextView) itemView.findViewById(R.id.recycle_item_name_tv);
            words = (TextView) itemView.findViewById(R.id.recycle_item_words_tv);
            imageView = (ImageView) itemView.findViewById(R.id.recycle_item_img);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearSel);

            linearLayout.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onUserItemClick(getAdapterPosition());
            }
        }

        public interface ItemClickListener {
            void onUserItemClick(int position);
        }
    }
}

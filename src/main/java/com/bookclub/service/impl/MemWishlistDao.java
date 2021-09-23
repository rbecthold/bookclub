package com.bookclub.service.impl;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import java.util.ArrayList;
import java.util.List;

public class MemWishlistDao implements WishlistDao {
    private List<WishlistItem> wishlist;

    public MemWishlistDao() {
        this.wishlist = new ArrayList<WishlistItem>();
        this.wishlist.add(new WishlistItem("978-0142437964", "In Search of Lost Time"));
        this.wishlist.add(new WishlistItem("978-1840226355", "Ulysses"));
        this.wishlist.add(new WishlistItem("978-0142437230", "Don Quixote"));
        this.wishlist.add(new WishlistItem("978-0061120091", "One Hundred Years of Solitude"));
        this.wishlist.add(new WishlistItem("978-0743273565", "The Great Gatsby"));
    }

    @Override
    public List<WishlistItem> list() {
        return this.wishlist;
    }

    @Override
    public WishlistItem find(String key) {
        for(WishlistItem wishlistItem : this.wishlist) {
            if(wishlistItem.getIsbn().equals(key)) {
                return wishlistItem;
            }
        }
        return new WishlistItem();
    }
}

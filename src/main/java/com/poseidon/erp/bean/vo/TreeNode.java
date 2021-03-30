package com.poseidon.erp.bean.vo;

import com.poseidon.erp.bean.enums.PermissionType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mario on 2020/10/28.
 */
@Getter
@Setter
public class TreeNode {
    protected Long id;

    protected Long parentId;

    protected String name;

    protected PermissionType type;

    protected List<TreeNode> children = new ArrayList<>();

    protected boolean hasChildren;

    public void add(TreeNode node) {
        children.add(node);
    }
}

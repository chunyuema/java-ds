class BinarySearchTreeNoNode {
    public int value;
    public BinarySearchTreeNoNode left;
    public BinarySearchTreeNoNode right;

    public BinarySearchTreeNoNode(int value) {
        this.value = value;
    }

    public BinarySearchTreeNoNode insert(int value) {
        if (value < this.value){
            if (this.left == null) this.left = new BinarySearchTreeNoNode(value);
            else this.left.insert(value);
        } else {
            if (this.right == null) this.right = new BinarySearchTreeNoNode(value);
            else this.right.insert(value);
        }
        return this;
    }

    public boolean contains(int value) {
        if (value < this.value){
            if (this.left == null) return false;
            else return this.left.contains(value);
        } else if (value > this.value){
            if (this.right == null) return false;
            else return this.right.contains(value);
        } else return true;
    }

    public BinarySearchTreeNoNode remove(int value) {
        this.remove(value, null);
        return this;
    }

    public void remove(int value, BinarySearchTreeNoNode parent) {
        if (value < this.value){
            if (this.left != null) this.left.remove(value, this);
        } else if (value > this.value){
            if (this.right != null) this.right.remove(value, this);
        } else {
            if (this.left != null && this.right != null){
                this.value = this.right.getMinValue();
                this.right.remove(this.value, this);
            } else if (parent == null){
                if (this.left != null){
                    this.value = this.left.value;
                    this.right = this.left.right;
                    this.left = this.left.left;
                } else if (this.right != null){
                    this.value = this.right.value;
                    this.right = this.right.right;
                    this.left = this.right.left;
                } else {
                }
            } else if (parent.left == this){
                parent.left = this.left != null ? left : right;
            } else if (parent.right == this){
                parent.right = this.left != null ? left : right;
            }
        }
    }

    public int getMinValue(){
        if (this.left == null) return this.value;
        else return this.left.getMinValue();
    }

    public void printTree(){
        if (this.left == null && this.right == null){
            System.out.print(this.value + " ");
            return;
        }
        if (this.left != null) this.left.printTree();
        System.out.println(this.value + " ");
        if (this.right != null) this.right.printTree();
    }
}

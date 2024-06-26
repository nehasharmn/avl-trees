
package assn06;

public class AVLTree<T extends Comparable<T>> implements SelfBalancingBST<T> {
    // Fields
    private T _value;
    private AVLTree<T> _left;
    private AVLTree<T> _right;
    private int _height;
    private int _size;
    
    public AVLTree() {
        _value = null;
        _left = null;
        _right = null;
        _height = -1;
        _size = 0;
    }

    /**
     * Rotates the tree left and returns
     * AVLTree root for rotated result.
     */

    private void heightChange(){
        if (this.isEmpty()){
            _height = -1;
            _size = 0;
        }
        else{
            int theHeight = Math.max(_left.height(),_right.height());
            _height = theHeight + 1;
            _size = _left.size() + _right.size() + 1;
        }
    }

     private AVLTree<T> rotateLeft() {
         // You should implement left rotation and then use this 
         // method as needed when fixing imbalances.
         // TODO
         AVLTree<T> rChild = this._right;
         this._right = rChild._left;
         rChild._left = this;
         this.heightChange();
         rChild.heightChange();
         return rChild;
     }


         /**
          * Rotates the tree right and returns
          * AVLTree root for rotated result.
          */
     private AVLTree<T> rotateRight() {
         // You should implement right rotation and then use this 
         // method as needed when fixing imbalances.
    	 // TODO
         AVLTree<T> lChild = this._left;
         this._left = lChild._right;
         lChild._right = this;
         this.heightChange();
         lChild.heightChange();
         return lChild;
     }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int height() {
        return _height;
    }

    @Override
    public int size() {
        return _size;
    }

    int balanceRotation() {

        return _right._height - _left._height;
    }
    public AVLTree<T> rotate() {
        if (this.isEmpty()) {
            return this;
        }
        int balance = balanceRotation();
        if (balance > 1) {
            if (_right.balanceRotation () < 0) {
                _right = _right.rotateRight();
            }
            return this.rotateLeft();
        } else if (balance < -1) {
            if (_left.balanceRotation() > 0) {
                _left = _left.rotateLeft();
            }
            return this.rotateRight();
        }
        return this;
    }

     @Override
     public SelfBalancingBST<T> insert(T element) {
         // TODO
         if (this.isEmpty()) {
             _value = element;
             _left = new AVLTree<>();
             _right = new AVLTree<>();
             _height = 0;
             _size = 1;
         } else if (this._value.compareTo(element) <= 0) {
             _right = (AVLTree<T>) _right.insert(element);
         } else {
             _left = (AVLTree<T>) _left.insert(element);
         }
         this.heightChange();
         return this.rotate();

         //return this;
     }

     @Override
     public SelfBalancingBST<T> remove(T element) {
         // TODO
         if (this.isEmpty()){
            return this;
         }
         if(_value.compareTo(element) < 0){
             _right = (AVLTree<T>)_right.remove(element);

         } else if (_value.compareTo(element)>0) {
             _left = (AVLTree<T>)_left .remove(element);
         }else {
             if (_right.isEmpty()) {
                 return _left;
             } else if (_left.isEmpty()) {
                 return _right;
             }
             AVLTree<T> replacementTree = _right;
             while (!replacementTree.getLeft().isEmpty()) {
                 replacementTree = (AVLTree<T>) replacementTree.getLeft();
             }
             this._value = replacementTree._value;
             this._right = (AVLTree<T>) this._right.remove(replacementTree._value);
         }

         this.heightChange();
         return this.rotate();
     }


         @Override
    public T findMin() {
         if (isEmpty()) {
             throw new RuntimeException("Illegal operation on empty tree");
         }
         if (_left.isEmpty()) {
             return _value;
         } else {
             return _left.findMin();
         }
    }

    @Override
    public T findMax() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal operation on empty tree");
        }
        if (_right.isEmpty()) {
            return _value;
        } else {
            return _right.findMax();
        }
    }

    @Override
    public boolean contains(T element) {
    	// TODO
        if (this.isEmpty()) {
            return false;
        }

        if (element.compareTo(_value) < 0) {
            return _left.contains(element);
        } else if (element.compareTo(_value) > 0) {
            return _right.contains(element);
        } else {
            return true;
        }
    }

    @Override
    public T getValue() {
        return _value;
    }

    @Override
    public SelfBalancingBST<T> getLeft() {
        if (isEmpty()) {
            return null;
        }
        return _left;
    }

    @Override
    public SelfBalancingBST<T> getRight() {
        if (isEmpty()) {
            return null;
        }
         return _right;
    }


public int rightHeight() {
    return _right.height();
}

public int leftHeight() {
         return _left.height();
}


}
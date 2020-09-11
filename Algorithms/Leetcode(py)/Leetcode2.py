class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        

class Solution:
    """two pointer
    """
    def addTwoNumbers(self, l1, l2):
        carry = 0
        dummy = curr = ListNode(0)
        while l1 or l2:
            val = carry
            if l1:
                val += l1.val
                l1 = l1.next
            if l2:
                val += l2.val
                l2 = l2.next
            curr.next = ListNode(val % 10)
            curr = curr.next
            carry = val // 10
        if carry > 0:
            curr.next = ListNode(carry)
        return dummy.next

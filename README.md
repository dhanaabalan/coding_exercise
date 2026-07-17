# Coding Practice

Practice log for coding — problems solved, approach, and complexity analysis. Written and solved independently in IntelliJ, then reviewed for correctness, complexity, and code quality.

## Problems

| # | Problem | Topic | Time | Space | Status |
|---|---------|-------|------|-------|--------|
| 1 | [Order Batching by Priority](#1-order-batching-by-priority) | Sorting / Stability | O(n log n) | O(n) | ✅ Solved |
| 2 | [Reconciliation Window](#2-reconciliation-window) | Sliding Window | O(n) target | O(1) target | ✅ Solved |

---

### 1. Order Batching by Priority

**Problem:** Given a list of transactions (id, priority 1–5, amount), group them into batches of size `k`, sorted by descending priority with stable tie-breaking on original order.

**Approach:** Stable sort (`Comparator.comparingInt().reversed()`, backed by TimSort) on priority descending, then chunk the sorted list into sublists of size `k`.

**Complexity:** O(n log n) time (sort-dominated), O(n) space for the sorted copy.

**File:** `OrderBatching.java`

---

### 2. Reconciliation Window

**Problem:** Given a sorted array of transaction timestamps and a window size `w`, find the maximum number of transactions that fall within any single window of size `w`.

**Approach:** Two-pointer sliding window. `left` and `right` pointers each advance forward only (never restart), expanding while `timestamps[right] - timestamps[left] <= w`, shrinking from the left when the window is invalid. Track the max window size seen.

**Complexity target:** O(n) time, O(1) space — single pass, no nested loop.

**File:** `SlidingWindow.java`

---

## Notes

- Each solution aims for the optimal time/space complexity, not just a correct answer.
- Focus areas: correctness on edge cases, complexity discipline, and verbal walk-through of approach before coding.

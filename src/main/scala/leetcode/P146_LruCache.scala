package leetcode

object P146_LruCache {

  case class Node[K, V](l: Option[K], v: V, r: Option[K])
  case class State[K, V](m: Map[K, Node[K, V]], head: Option[K], tail: Option[K], n: Int)

  object Cache {
    import DLList._

    def put[K, V](s: State[K, V], k: K, v: V, n: Int): State[K, V] = {
      val s1 = prepend(remove(s, k), k, v)
      if (s1.n <= n) s1
      else init(s1)
    }

    def get[K, V](s: State[K, V], k: K): (State[K, V], Option[V]) =
      s.m.get(k) match {
        case None       => (s, None)
        case Some(node) => (prepend(remove(s, k), k, node.v), Some(node.v))
      }
  }

  object DLList {

    def prepend[K, V](s: State[K, V], k: K, v: V): State[K, V] = {
      val m1 = s.m.updated(k, Node(None, v, s.head))

      val m2 = s.head match {
        case None     => m1
        case Some(rk) => m1.updated(rk, s.m(rk).copy(l = Some(k)))
      }

      s.copy(m = m2, head = Some(k), tail = Some(s.tail.getOrElse(k)), n = s.n + 1)
    }

    def init[K, V](s: State[K, V]): State[K, V] =
      s.tail.fold(s)(remove(s, _))

    def remove[K, V](s: State[K, V], k: K): State[K, V] =
      s.m.get(k) match {
        case None => s
        case Some(node) =>
          val m1 = node.l match {
            case None     => s.m
            case Some(lk) => s.m.updated(lk, s.m(lk).copy(r = node.r))
          }

          val m2 = node.r match {
            case None     => m1
            case Some(rk) => m1.updated(rk, m1(rk).copy(l = node.l))
          }

          val h = s.head.flatMap(h => if (h == k) node.r else s.head)
          val t = s.tail.flatMap(t => if (t == k) node.l else s.tail)
          s.copy(m = m2.removed(k), head = h, tail = t, n = s.n - 1)
      }
  }

  class LRUCache(_capacity: Int) {
    var ref: State[Int, Int] = State(Map.empty, None, None, 0)

    def get(key: Int): Int = {
      val (s, v) = Cache.get(ref, key)
      ref = s
      v.getOrElse(-1)
    }

    def put(key: Int, value: Int): Unit = {
      ref = Cache.put(ref, key, value, _capacity)
    }
  }

}

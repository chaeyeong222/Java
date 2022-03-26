package days13;

import java.util.Arrays;

public class Ex01 {

	   public static void main(String[] args) {
		      // 배열 , 제어문  응용 및 활용
		      // >13   2022-03-07(월)<
		      // 배열, 정렬(Sort) - 버블정렬, 선택정렬
		      // [병합정렬( Merge Sort)]
		      // - 비교 기반 정렬 알고리즘
		      // -  7 4           3 8                 2 5            1 6             800개
		      //     4 7           3 8                 2 5            1 6             200개 * 4 
		      //           3 4 7 8                           1 2 5 6
		      //                           1 2 3 4 5 6 7 8
		      
		      // - 이미 정렬이 되어져 있는 두 개의 배열을 합병하여 한 개의 배열로 만드는 정렬 방식
		      int [] m = { 1, 3, 6 }; 
		      int mIdx = 0;
		      
		      int [] n = { 2, 4, 5, 7, 8, 9 };
		      int nIdx = 0;
		      
		      int [] mn = new int[m.length + n.length ]; // 3+6=9 
		      int mnIdx = 0;
		      
		      // 설명하는 로직을 이해하고 코딩으로 옮기는 연습
		      /*
		      if( m[mIdx]  >  n[nIdx] )   mn[mnIdx++] = n[nIdx++];
		      else                                   mn[mnIdx++] = m[mIdx++];
		      
		      if( m[mIdx]  >  n[nIdx] )   mn[mnIdx++] = n[nIdx++];
		      else                                   mn[mnIdx++] = m[mIdx++];
		      
		      if( m[mIdx]  >  n[nIdx] )   mn[mnIdx++] = n[nIdx++];
		      else                                   mn[mnIdx++] = m[mIdx++];
		      
		      if( m[mIdx]  >  n[nIdx] )   mn[mnIdx++] = n[nIdx++];
		      else                                   mn[mnIdx++] = m[mIdx++];
		      
		      if( m[mIdx]  >  n[nIdx] )   mn[mnIdx++] = n[nIdx++];
		      else                                   mn[mnIdx++] = m[mIdx++]; 

		      if( m[mIdx]  >  n[nIdx] )   mn[mnIdx++] = n[nIdx++];
		      else                                   mn[mnIdx++] = m[mIdx++];
		      
		      :
		      */
		      /*
		      while(true) {
		         if( m[mIdx]  >  n[nIdx] )   mn[mnIdx++] = n[nIdx++];
		         else                                   mn[mnIdx++] = m[mIdx++];
		         if( mIdx == m.length  ||  nIdx == n.length ) break;
		      }
		      */
		      
		      while(  mIdx != m.length  &&  nIdx != n.length) {
		         mn[mnIdx++] = ( m[mIdx]  >  n[nIdx] ) ? n[nIdx++] : m[mIdx++];
		      }
		      System.out.println( Arrays.toString(mn) );
		      // 남은 [배열을 복사] 코딩 추가
		      /*
		       if (m.length  == mIdx) {   // n 배열이 남아있다.
		         for (int i = nIdx; i < n.length; i++) {
		            mn[mnIdx++] = n[i];
		         }
		      } else {                             // m 배열이 남아있다.
		         for (int i = mIdx; i < m.length; i++) {
		            mn[mnIdx++] = m[i];
		         }
		      }
		      */
		      
		       int [] temp = (m.length  == mIdx) ?  n : m;  // 남은 배열
		       int tempIdx = (m.length  == mIdx) ?  nIdx : mIdx;  // 남은 배열의 인덱스        
		       
		      for (int i = tempIdx; i < temp.length; i++) {
		         mn[mnIdx++] = temp[i];
		      }
		      
		      // 배열 복사 - 남아있는 배열 찾아야 ... 
		      //System.arraycopy(src, srcPos, dest, destPos, length);      
		       System.out.println( Arrays.toString(mn) );
		         
		      
		   } // main

		} // class


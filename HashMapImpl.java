{\rtf1\ansi\ansicpg1252\cocoartf2636
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fnil\fcharset0 Menlo-Regular;}
{\colortbl;\red255\green255\blue255;\red0\green0\blue255;\red255\green255\blue255;\red0\green0\blue0;
\red32\green108\blue135;\red0\green0\blue109;\red101\green76\blue29;\red19\green118\blue70;\red157\green0\blue210;
}
{\*\expandedcolortbl;;\cssrgb\c0\c0\c100000;\cssrgb\c100000\c100000\c100000;\cssrgb\c0\c0\c0;
\cssrgb\c14902\c49804\c60000;\cssrgb\c0\c6275\c50196;\cssrgb\c47451\c36863\c14902;\cssrgb\c3529\c52549\c34510;\cssrgb\c68627\c0\c85882;
}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs26 \cf2 \cb3 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 //Time complexity is O(1) as array lookup is O(1)\
//Space complexity is O(N) where N is 1000006\
class\cf0 \strokec4  \cf5 \strokec5 MyHashMap\cf0 \strokec4  \{\cb1 \
\pard\pardeftab720\partightenfactor0
\cf0 \cb3     \cf5 \strokec5 int\cf0 \strokec4  \cf6 \strokec6 size\cf0 \strokec4  = (\cf5 \strokec5 int\cf0 \strokec4 )\cf6 \strokec6 Math\cf0 \strokec4 .\cf7 \strokec7 pow\cf0 \strokec4 (\cf8 \strokec8 10\cf0 \strokec4 , \cf8 \strokec8 6\cf0 \strokec4 )+\cf8 \strokec8 1\cf0 \strokec4 ;\cb1 \
\cb3     \cf5 \strokec5 int\cf0 \strokec4 [] \cf6 \strokec6 hm\cf0 \strokec4  = \cf9 \strokec9 new\cf0 \strokec4  \cf5 \strokec5 int\cf0 \strokec4 [size];\cb1 \
\cb3     \cf2 \strokec2 public\cf0 \strokec4  \cf7 \strokec7 MyHashMap\cf0 \strokec4 () \{\cb1 \
\cb3         \cf6 \strokec6 Arrays\cf0 \strokec4 .\cf7 \strokec7 fill\cf0 \strokec4 (hm, -\cf8 \strokec8 1\cf0 \strokec4 );\cb1 \
\cb3     \}\cb1 \
\cb3     \cb1 \
\cb3     \cf2 \strokec2 public\cf0 \strokec4  \cf5 \strokec5 void\cf0 \strokec4  \cf7 \strokec7 put\cf0 \strokec4 (\cf5 \strokec5 int\cf0 \strokec4  \cf6 \strokec6 key\cf0 \strokec4 , \cf5 \strokec5 int\cf0 \strokec4  \cf6 \strokec6 value\cf0 \strokec4 ) \{\cb1 \
\cb3         hm[key] = value;\cb1 \
\cb3     \}\cb1 \
\cb3     \cb1 \
\cb3     \cf2 \strokec2 public\cf0 \strokec4  \cf5 \strokec5 int\cf0 \strokec4  \cf7 \strokec7 get\cf0 \strokec4 (\cf5 \strokec5 int\cf0 \strokec4  \cf6 \strokec6 key\cf0 \strokec4 ) \{\cb1 \
\cb3         \cf9 \strokec9 return\cf0 \strokec4  hm[key];\cb1 \
\cb3     \}\cb1 \
\cb3     \cb1 \
\cb3     \cf2 \strokec2 public\cf0 \strokec4  \cf5 \strokec5 void\cf0 \strokec4  \cf7 \strokec7 remove\cf0 \strokec4 (\cf5 \strokec5 int\cf0 \strokec4  \cf6 \strokec6 key\cf0 \strokec4 ) \{\cb1 \
\cb3         hm[key]=-\cf8 \strokec8 1\cf0 \strokec4 ;\cb1 \
\cb3     \}\cb1 \
\cb3 \}\cb1 \
\
}
'use client'
import Link from "next/link";
import { useRouter } from "next/navigation";
import React, { useCallback, useState } from "react";
import { z } from "zod";
import {apiUrl} from "@/constants/api";

const NewRecord: React.FC = () => {
  const router = useRouter();
  // フォームの入力値を管理するためのstate
  const [title, setTitle] = useState("");
  const [readDate, setReadDate] = useState("");
  // 作成APIを呼び出す関数
  const createNote = useCallback(async () => {
    const res = await fetch(`${apiUrl}/record`, {
      method: 'POST',
      body: JSON.stringify({ title, readDate }),
      headers: {
        'Content-Type': 'application/json'
      }
    });
    if (res.ok) {
      const id: number = z.number().parse(await res.json());
      alert(`Record created: ${id}`);
      // 詳細ページが実装されたら、詳細ページに遷移するようにする
      router.push(`/records`);
      // 現在のページのデータをサーバーから再取得する
      router.refresh();
    } else {
      alert('Note failed to create');
    }
  }, [readDate, router, title]);

  return (
      <div className="flex flex-col bg-gray-100 rounded-lg relative p-5 gap-2.5">
        <div className="sm:col-span-2">
          <label htmlFor="title" className="inline-block text-gray-800 text-sm sm:text-base mb-2">Title</label>
          <input
              name="title"
              className="w-full bg-gray-50 text-gray-800 border focus:ring ring-pink-300 rounded outline-none transition duration-100 px-3 py-2"
              value={title}
              onChange={(e) => setTitle(e.target.value)}
          />
        </div>
        <div className="sm:col-span-2">
          <label htmlFor="title" className="inline-block text-gray-800 text-sm sm:text-base mb-2">読んだ日</label>
          <div className="relative max-w-sm">
            <input
                type="date"
                name="readDate"
                className="w-full bg-gray-50 text-gray-800 border focus:ring ring-pink-300 rounded outline-none transition duration-100 px-3 py-2"
                value={readDate}
                onChange={(e) => setReadDate(e.target.value)}
            />
          </div>
        </div>
        <div className="flex flex-col sm:flex-row sm:justify-end gap-2.5">
          <Link href={`/notes`} className="inline-block bg-gray-200 hover:bg-gray-300 focus-visible:ring ring-pink-300 text-gray-500 active:text-gray-700 text-sm md:text-base font-semibold text-center rounded-lg outline-none transition duration-100 px-8 py-2">Cancel</Link>
          <button onClick={createNote} className="inline-block bg-pink-500 hover:bg-pink-600 active:bg-pink-700 focus-visible:ring ring-pink-300 text-white text-sm md:text-base font-semibold text-center rounded-lg outline-none transition duration-100 px-8 py-2">Create</button>
        </div>
      </div>
  );
}

export default NewRecord;

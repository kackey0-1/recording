'use client'
import {Bar, BarChart, ResponsiveContainer, Tooltip, XAxis, YAxis,} from "recharts";
import React, {Suspense} from "react";
import {getBookRecords} from "@/app/records/getBookRecords";
import FetchError from "@/components/FetchError";
import Loading from "@/components/Loading";
import ErrorBoundary from "@/components/ErrorBoundary";

const data = [
    {read_date: "2024-04-01", amt: 24},
    {read_date: "2024-04-02", amt: 22},
    {read_date: "2024-04-03", amt: 22},
    {read_date: "2024-04-04", amt: 25},
    {read_date: "2024-04-05", amt: 21},
];

// @ts-ignore
const renderCustomBarLabel = ({payload, x, y, width, height, value}) => {
    return <text x={x + width / 2} y={y} fill="#666" textAnchor="middle" dy={-6}>{`${value}`}</text>;
};

export default async function Page() {
    const bookRecords = await getBookRecords();
    // APIを用いたデータ取得
    return (
        <main className="mx-2 sm:mx-4 relative">
            { /* recharts */}
            <ErrorBoundary fallback={<FetchError/>}>
                <Suspense fallback={<Loading/>}>
                    <ResponsiveContainer width="100%" height={400}>
                        <BarChart width={600} height={400} data={bookRecords}>
                            <XAxis dataKey="readDate"/>
                            <YAxis/>
                            <Tooltip/>
                            <Bar dataKey="amount" barSize={30} fill="#8884d8" label={renderCustomBarLabel}/>
                        </BarChart>
                    </ResponsiveContainer>
                </Suspense>
            </ErrorBoundary>
        </main>
    )
}

